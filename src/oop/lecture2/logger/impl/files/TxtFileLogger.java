package oop.lecture2.logger.impl.files;

public class TxtFileLogger extends FileLogger {

    public TxtFileLogger(String fileName) {
//        super.fileName = fileName + getFileExtension();
        super(fileName);
    }

    public TxtFileLogger() {
        super();
    }

    @Override
    public String getFileExtension() {
        return ".txt";
    }
}