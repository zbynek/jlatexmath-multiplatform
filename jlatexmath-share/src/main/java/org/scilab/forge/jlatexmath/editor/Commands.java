package org.scilab.forge.jlatexmath.editor;

import java.util.HashMap;

public class Commands 
{
	public static HashMap<String, Integer> commands = new HashMap<String, Integer>();
	static
	{
		commands.put("sqrt", 1);
	}
	public static int getValue(String com)
	{
		try
		{
			return commands.get(com);
		}
		catch(Exception e)
		{
			return 0;
		}
	}
}
