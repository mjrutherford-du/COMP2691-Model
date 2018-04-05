public class Main implements Constants
{
    public static void main(String[] args)
    {
	Computer comp = new Computer(2*GHz, BYTES_PER_GB);
	Executable executable1 = new Executable();
	comp.run(executable1);
    }
}
