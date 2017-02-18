package interviewexcercises.orgconflict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Deodhar Family on 2/16/2017.
 *          				  				CEO
 *          				 SVP1-SBG                    |                       SVP2-CTG
 *      		VP1   			|  VP2                               				 VP3
 *    		  Anil      		|        AnilC
 *  	Seema     Archana   	|  			Aijaz                                     Ojas [ IC ]
 *  Peter,Akshay   Rick,Raja 	|  			Sujeeth
 *
 *
 */
public class Company {

	List<Employee> employees;
	//SBG ---------------------------------
	//ICs
	Employee akshay = new Employee(new HashSet<>(),"Akshay",0);
	Employee peter = new Employee(new HashSet<Employee>(),"Peter",0);
	Employee rick = new Employee(new HashSet<Employee>(),"Rick",0);
	Employee raja = new Employee(new HashSet<Employee>(),"Raja",0);

	//L2 managers
	Employee seema = new Employee(new HashSet<Employee>(Arrays.asList(akshay,peter)),"Seema",2);
	Employee archana = new Employee(new HashSet<Employee>(Arrays.asList(rick,raja)),"Archana",2);

	//Directors
	Employee anil = new Employee(new HashSet<Employee>(Arrays.asList(seema,archana)),"Anil",2);
	//VP
	Employee vp1 = new Employee(new HashSet<Employee>(Arrays.asList(anil)),"VP1",3);



	//ICs
	Employee sujeeth = new Employee(new HashSet<Employee>(),"Sujeeth",0);
	//L1 managers
	Employee aijaz = new Employee(new HashSet<Employee>(Arrays.asList(sujeeth)),"Aijaz",1);

	//Directors
	Employee anilc = new Employee(new HashSet<Employee>(Arrays.asList(aijaz)),"Anilc",2);
	//VP
	Employee vp2 = new Employee(new HashSet<Employee>(Arrays.asList(anilc)),"VP2",3);
	//SVP
	Employee svp1 = new Employee(new HashSet<Employee>(Arrays.asList(vp1,vp2)),"SVP1",4);

	//CTG ----------------------------------

	//ICs
	Employee ojas = new Employee(new HashSet<Employee>(),"Ojas",0);
	//Directors - no one
	//VP
	Employee vp3 = new Employee(new HashSet<Employee>(Arrays.asList(ojas)),"VP3",3);

	Employee svp2 = new Employee(new HashSet<Employee>(Arrays.asList(vp3)),"VP2",4);

	Employee ceo = new Employee(new HashSet<Employee>(Arrays.asList(svp1,svp2)),"CEO",5);


	public  void createOrg(){
		employees = new ArrayList<Employee>();
		akshay.setManager(seema);
		peter.setManager(seema);
		rick.setManager(archana);
		raja.setManager(archana);

		seema.setManager(anil);
		archana.setManager(anil);
		anil.setManager(vp1);
		vp1.setManager(svp1);

		sujeeth.setManager(aijaz);
		aijaz.setManager(anilc);
		anilc.setManager(vp2);
		vp2.setManager(svp1);

		ojas.setManager(vp3);
		vp3.setManager(svp2);

		svp1.setManager(ceo);
		svp2.setManager(ceo);
		ceo.setManager(ceo);

	}
	public Employee resolveConflict(Employee a, Employee b){
		Employee resolver=null;
		if(a.getManager().equals(b.getManager())){
			resolver = a.getManager();
			return resolver;
		}
		if( a.getManager().equals(b)){
			resolver = b;
			return resolver;
		}
		if( b.getManager().equals(a)){
			resolver = a;
			return resolver;
		}
		if(a.getLevel()<b.getLevel()){
			return resolveConflict(a.getManager(),b);
		}else if(a.getLevel()>b.getLevel()){
			return resolveConflict(a,b.getManager());
		}else if(a.getLevel() == b.getLevel()){
			return resolveConflict(a.getManager(),b.getManager());
		}

		return resolver;
	}

	public static void main(String args[]){
		Company intuit = new Company();
		intuit.createOrg();
		Employee resolver = intuit.resolveConflict(intuit.peter,intuit.rick);
		System.out.println("Conflict - peter and rick - resolver = "+resolver.toString());
		resolver = intuit.resolveConflict(intuit.peter,intuit.aijaz);
		System.out.println("Conflict - peter and aijaz - resolver = "+resolver.toString());
		resolver = intuit.resolveConflict(intuit.peter,intuit.anil);
		System.out.println("Conflict - peter and Anil - resolver = "+resolver.toString());
		resolver = intuit.resolveConflict(intuit.peter,intuit.vp1);
		System.out.println("Conflict - peter and Vp1 - resolver = "+resolver.toString());
		resolver = intuit.resolveConflict(intuit.peter,intuit.sujeeth);
		System.out.println("Conflict - peter and Sujeeth - resolver = "+resolver.toString());
		resolver = intuit.resolveConflict(intuit.peter,intuit.vp2);
		System.out.println("Conflict - peter and vp2 - resolver = "+resolver.toString());

		resolver = intuit.resolveConflict(intuit.peter,intuit.ceo);
		System.out.println("Conflict - peter and ceo - resolver = "+resolver.toString());

		resolver = intuit.resolveConflict(intuit.raja,intuit.peter);
		System.out.println("Conflict - peter and raja - resolver = "+resolver.toString());
		resolver = intuit.resolveConflict(intuit.aijaz,intuit.archana);
		System.out.println("Conflict - aijaz and archana - resolver = "+resolver.toString());

		resolver = intuit.resolveConflict(intuit.seema,intuit.ojas);
		System.out.println("Conflict - seema and ojas - resolver = "+resolver.toString());

		resolver = intuit.resolveConflict(intuit.rick,intuit.aijaz);
		System.out.println("Conflict - rick and aijaz - resolver = "+resolver.toString());
		resolver = intuit.resolveConflict(intuit.archana,intuit.seema);
		System.out.println("Conflict - archana and seema - resolver = "+resolver.toString());
	}
}
