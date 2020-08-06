public class EmpWageBuilderUC1
{
	public static final int IS_FULL_TIME=1;
        public static final int IS_PART_TIME=2;
        public static final int EMP_RATE_PER_HOUR=20;
	public static final int NUM_WORKING_DAYS=20;
        public static final int MAX_HR_IN_MONTH=100;

	public static int computeEmpWage()
	{
		
		int empWage=0;
		int empHrs=0;
		int totalEmpHrs=0;
		int totalWorkingDays=0;
		int totalSalary;;
		while(totalEmpHrs<MAX_HR_IN_MONTH && totalWorkingDays<NUM_WORKING_DAYS) 
		{
		totalWorkingDays++;
		double empCheck=Math.floor(Math.random()*10)%3;
		switch((int)empCheck)
		{
		case IS_FULL_TIME:
				empHrs=8;
				break;
		case IS_PART_TIME:
			empHrs=4;
			break;
		default:
		empHrs=0;
		}
		
		totalEmpHrs=totalEmpHrs+empHrs;
		System.out.println("Days #"+totalWorkingDays+ "Emp Hrs:" +empHrs);
		}
	totalSalary=totalEmpHrs*EMP_RATE_PER_HOUR;
	System.out.println("Employee Wage:"+totalSalary);
	return totalSalary;
	}
	
	public static void main(String[] args)
	{
		computeEmpWage();
	}
}
