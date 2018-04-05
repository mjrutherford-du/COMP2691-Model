/**
 * Class representing the functionality of a generic computer.
 */

public class Computer implements Constants
{
    private final double m_clockFrequency;
    private final Memory m_memory;

    public Computer(double clockFrequency, int memoryBytes)
    {
	m_clockFrequency = clockFrequency;
	m_memory = new Memory(memoryBytes);
    }

    public double getClockCycleTime_s()
    {
	return 1.0 / m_clockFrequency;
    }

    public double getClockCycleTime_ms()
    {
	return getClockCycleTime_s() * MS_PER_SEC;
    }

    public double getClockCycleTime_ns()
    {
	return getClockCycleTime_s() * NS_PER_SEC;
    }

    public void run(Executable e)
    {
    }
}
