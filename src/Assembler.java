/** Class representing the functionality of the "assembler" program
 * that takes text assembly code and creates a machine-code executable.
 */
public class Assembler
{
    public Executable assemble(AssemblyCode ac)
    {
	Executable e = new Executable();
	Instruction[] instructions = ac.getInstructions();
	for(Instruction i : instructions){
	    e.add(i.encode());
	}
	return e;
    }
}
