package org.southriverhi.space.DNASharp;

import java.io.IOException;

public interface Instruction {

    public void execute(Context c) throws IOException;

    /**
     * Gets the 'bracket count:
     * <ul>
     *   <li>1, if this is a forward {@link CondJump}</li>
     *   <li>-1, if this is a backward {@link CondJump}</li>
     *   <li>0 otherwise</li>
     * </ul>
     * @return the 'bracket count'
     */
    public int getJumpCount();
}