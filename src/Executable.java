import java.util.ArrayList;
/**
   Represents the code for a single program.
 */
public class Executable
{
    private ArrayList<MachineInstruction> m_instructions = new ArrayList<MachineInstruction>();

    public void add(MachineInstruction instruction)
    {
	m_instructions.add(instruction);
    }

    public MachineInstruction[] getMachineInstructions()
    {
	return m_instructions.toArray( new MachineInstruction[m_instructions.size()] );
    }
}
