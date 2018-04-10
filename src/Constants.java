public interface Constants
{
    public static final int BITS_PER_BYTE = 8;

    public static final int BYTES_PER_KB = 1024; // kibibytes
    public static final int BYTES_PER_MB = 1024*BYTES_PER_KB; // mebibytes
    public static final int BYTES_PER_GB = 1024*BYTES_PER_MB; // gibibyte
    
    public static final double KHz = 1000.0; // kilohertz
    public static final double MHz = 1000.0*KHz; // megahertz
    public static final double GHz = 1000.0*MHz; // gigahertz

    public static final double MS_PER_SEC = 1000.0; // milliseconds
    public static final double US_PER_SEC = 1000.0*MS_PER_SEC; // microseconds
    public static final double NS_PER_SEC = 1000.0*US_PER_SEC; // nanoseconds
    public static final double PS_PER_SEC = 1000.0*NS_PER_SEC; // picoseconds
}
