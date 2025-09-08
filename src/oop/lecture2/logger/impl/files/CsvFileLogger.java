package oop.lecture2.logger.impl.files;

public class CsvFileLogger extends FileLogger {

    public CsvFileLogger(String fileName) {
        super.fileName = fileName + getFileExtension();
    }

    public CsvFileLogger() {
        super();
    }

    @Override
    public String getFileExtension() {
        return ".csv";
    }
}