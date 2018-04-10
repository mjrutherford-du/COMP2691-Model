public class Main
{
    public static void main(String[] args)
    {
	Computer comp = new Computer(2*Constants.GHz, Constants.BYTES_PER_GB);
	Executable executable1 = new Executable();
	comp.run(executable1);
    }
}
