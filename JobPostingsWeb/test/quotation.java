import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class quotation 
{
    
	public static String getCommand()
	{
		    System.out.println("Enter your command here:");
		    Scanner keyboard=new Scanner(System.in);
		    String str=keyboard.nextLine();
		    String command=str.toUpperCase();
		    return command;
	}
	
	public static void main(String[] args) 
	{
	    ArrayList<String>productlist=new ArrayList<String>();
		ArrayList<String>vendorlist=new ArrayList<String>();
		ArrayList<String>pricelist=new ArrayList<String>();
     
		System.out.println("\tWelcome to the online quotation services, functions provided include the following:\n\tNew\n\tUpdate\n\tAsk\n\tQuit\n");
        while(true)
        {
		String choice;
        choice=getCommand();
        char n=choice.charAt(0);  
        
        switch(n)
        {
        case 'N':{           
        	          New(productlist,vendorlist,pricelist); 
        	          
                 }
        continue;
        case 'U':{
                      Update(productlist,vendorlist,pricelist);                   
                 }
        continue;       
        case 'A':{
                      Ask(productlist,vendorlist,pricelist);                    
                 }
        continue;
        case 'Q':{
            	      Quit();
                 }
        break;  
        default:{
        	          System.out.println("Your command is not right!");
                }
        continue;
        }
        } 
	}
	
	public static void New(ArrayList productlist,ArrayList vendorlist,ArrayList pricelist)
    { 
    	while(true)
    	{
    		int flag=0,i;
    		String item;
    		String saleman;
    		String money;
    		System.out.println("new or quit:");
			Scanner keyboard=new Scanner(System.in);
			String str=keyboard.nextLine();
			str=str.toUpperCase();
			if(str.contentEquals("QUIT"))
				break;
			if(!str.contentEquals("NEW"))
				continue;
			   System.out.println("Enter a new product:");
			   item=keyboard.nextLine();
			   System.out.println("Vendor name:");
			   saleman=keyboard.nextLine();
			   for(i=0;i<productlist.size();i++)
			   {
				   if(item.equals(productlist.get(i)))
				   {
					   if(saleman.equals(vendorlist.get(i)))
					   {
						   System.out.println("This product exists already!");
						   flag=-1;
					   }
				   }
			   }
		   if(flag!=-1)
		   {
			System.out.println("Selling price:");
			money=keyboard.nextLine();
            productlist.add(i,item);
	        vendorlist.add(i,saleman);
	        pricelist.add(i,money);
	        System.out.println("New product "+item+"/"+saleman+" entered.");
            }
    	}
    }
    public static void Update(ArrayList productlist,ArrayList vendorlist,ArrayList pricelist)
    {
	        Scanner keyboard=new Scanner(System.in);
			System.out.println("Enter a new product:");
			String item;
			item=keyboard.nextLine();
			System.out.println("Vendor name:");
			String saleman;
			saleman=keyboard.nextLine();
			System.out.println("Selling price(RMB):");
			String money;
			money=keyboard.nextLine();
			for(int i=0;i<productlist.size();i++)
			{
			   if(item.equals(productlist.get(i)))
			   {
				   if(saleman.equals(vendorlist.get(i)))
				   {
					  pricelist.set(i,money);  
					  break;
				   }  
				   else
				   {
					   System.out.println("This product does not exist!");
				   }
			   }
			   else
			   {
				   System.out.println("This product does not exist!");
			   }
			}
			System.out.println(item+"/"+saleman+" price updated.");
    }

    public static void Ask(ArrayList productlist,ArrayList vendorlist,ArrayList pricelist)
    {
    	    Scanner keyboard=new Scanner(System.in);
    	    System.out.println("Enter product name:");
			String item;
			item=keyboard.nextLine();
			System.out.println("Enter vendor name(can be blank):");
			String saleman;
			saleman=keyboard.nextLine();
			boolean isSalemanNull = false;
			if(saleman == null|| saleman.equals(""))
				isSalemanNull = true;
			boolean isFind = false;
			if(isSalemanNull==false)
			{
				for(int i=0;i<productlist.size();i++)
				{
				   if(item.equals(productlist.get(i))&&saleman.equals(vendorlist.get(i)))
				   {
						   System.out.println("Selling price(RMB): "+"("+saleman+" "+item+", "+pricelist.get(i)+"); ");
						   isFind = true;
						   break;
				   }
	            }
			}
			else 
			{   
				StringBuffer stringBuffer = new StringBuffer("Selling price(RMB): ");
				for(int i=0;i<productlist.size();i++)
				{
				   
				   if(item.equals(productlist.get(i)))
				   {
						   stringBuffer.append("("+saleman+" "+item+", "+pricelist.get(i)+");");
						   isFind = true;
						   break;
				   }
	            }
				if(isFind)
					System.out.println(stringBuffer.toString());
			}
			if(!isFind)
			System.out.println("This product does not exist!");
    }

    public static void Quit()
    {
			System.out.println("Bye-Bye!");
			System.exit(0);
    }
}
