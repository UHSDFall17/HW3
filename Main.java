  	import org.apache.commons.cli.*;

public class Main {
	
	public int binSearch(Comparable<String>[] aList, Comparable<String> key)
		{
			
			int first, last, middle, newmiddle;
			first = 0;
			last = aList.length - 1;
			middle = (first + last)/2;
			while (first <= last)
			{
				if (key.compareTo(aList[middle].toString()) <0)
				{
					last = middle - 1;
					newmiddle = (first + last)/2;
					middle = newmiddle;
					}
				else if (key.compareTo(aList [middle].toString())>0)
				{
					first = middle + 1;
					newmiddle = (first + last)/2;
					middle = newmiddle;				
				}
				else if (key.compareTo(aList [middle].toString())==0)
				{
					System.out.println("The key is found (1)\n");
					return 0;
				}
				
			}
			System.out.println( "The key was not found! (0)\n");  
			return 0;
			}
		
		
		
		public static void main(String[] args){
			
			
            Options option1 = new Options();
              

            Option Optiontype = Option.builder("t").longOpt("type").hasArg().numberOfArgs(1).required(true).build();
            Option Optionkey = Option.builder("k").longOpt("key").hasArg().numberOfArgs(1).required(true).build();
            Option Optionlist = Option.builder("l").longOpt("list").hasArgs().valueSeparator(' ').required(true).build();
            option1.addOption(Optiontype);
            option1.addOption(Optionkey);
            option1.addOption(Optionlist);

            CommandLineParser cmdparser = new DefaultParser();
            CommandLine cmd;




            try {
            	cmd=cmdparser.parse(option1, args,true);
            	
                String type = cmd.getOptionValue("type");
                String key = cmd.getOptionValue("key");
                String[] list = cmd.getOptionValues("list");
                if(type == null)
                    throw new ParseException("Undefined type");
                if(key == null)
                    throw new ParseException("Undefined key");
                if(list == null)
                    throw new ParseException("List is empty");
                
                Main strsea = new Main();
    			if (type.equalsIgnoreCase("s")||type.equalsIgnoreCase("i"))
    			{
    				strsea.binSearch(list,key);
    			}  			
    			else
    			{
    				System.out.println("Wrong Input\n");
    			}
            }
            catch(ParseException error)
            {
                System.out.println("Input is missing");
                error.printStackTrace();
                System.exit(0);
            }		
			
	}
		
		

}
