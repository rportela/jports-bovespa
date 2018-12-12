package jports.b3.up2data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * This class contains useful methods for reading files from UP2DATA date
 * oriented directory structure;
 * 
 * @author rportela
 *
 * @param <T>
 */
public class Up2Data<T> {

	private final String up2dataRoot;
	private final Up2DataAspect<T> aspect;
	private final String separator;

	/**
	 * Creates a new Up2Data extractor;
	 * 
	 * @param up2dataRoot
	 * @param dataType
	 */
	public Up2Data(String up2dataRoot, Class<T> dataType) {
		this.up2dataRoot = up2dataRoot;
		this.aspect = new Up2DataAspect<>(dataType);
		this.separator = ";";
	}

	/**
	 * Gets the files of the underlying aspect for a specific date; If some
	 * information is updated, more than one file is profided;
	 * 
	 * @param date
	 * @return
	 */
	public File[] getFiles(Date date) {

		String formattedDate = new SimpleDateFormat("yyyyMMdd").format(date);
		Path filePath = aspect.getSubChannel().isEmpty()
				? Paths.get(
						up2dataRoot,
						aspect.getChannel(),
						formattedDate)
				: Paths.get(
						up2dataRoot,
						aspect.getChannel(),
						aspect.getSubChannel(),
						formattedDate);

		return filePath.toFile().listFiles(new FilenameFilter() {
			final String name_prefix = aspect.getFilePrefix();

			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith(name_prefix);
			}
		});
	}

	/**
	 * Gets just the latest file for a specific date. This methods gets all the
	 * files for that date, orders them by name and returns the last one.
	 * 
	 * @param date
	 * @return
	 */
	public File getLatestFile(Date date) {
		File[] files = getFiles(date);
		if (files.length == 0)
			return null;
		if (files.length == 1)
			return files[0];
		Arrays.sort(files, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return o2.getName().compareTo(o1.getName());
			}
		});
		return files[0];
	}

	/**
	 * Parses a specific file for the underlying aspect's data type;
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public List<T> parseFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ArrayList<T> list = new ArrayList<>(10000);
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(fis, Charset.forName("windows-1252")));
			try {

				String line = reader.readLine();
				if (line != null && !line.isEmpty()) {
					String[] headers = line.split(separator);

					Up2DataAspectMember<T>[] members = aspect.getColumnArray(headers);
					if (members.length == 0)
						throw new RuntimeException("No mapping of members found on " +
								aspect.getDataType() +
								". Perhaps you're missing something there.");

					while ((line = reader.readLine()) != null) {
						String[] cells = line.split(separator);
						T entity = aspect.newInstance();
						for (int i = 0; i < cells.length; i++) {
							if (members[i] != null)
								members[i].setValue(entity, cells[i]);
						}
						list.add(entity);
					}
				}

			} finally {
				reader.close();
			}

		} finally {
			fis.close();
		}
		return list;
	}

	/**
	 * Parses the latest file of a specific date;
	 * 
	 * @param date
	 * @return
	 * @throws IOException
	 */
	public List<T> parseLatestFile(Date date) throws IOException {

		File latestFile = getLatestFile(date);
		return latestFile == null
				? null
				: parseFile(latestFile);

	}
}
