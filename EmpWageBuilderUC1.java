public class EmpWageBuilderUC1
{
	public static void main(String[] args)
	{
		 final int IS_FULL_TIME=1;
		final int IS_PART_TIME=2;
		 final int EMP_RATE_PER_HOUR=20;
		int empWage=0;
		int empHrs=0;
		final int NUM_WORKING_DAYS=20;
		final int MAX_HR_IN_MONTH=100;
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
			{
				empHrs=8;
				break;
			}
		case IS_PART_TIME:
		{	
			empHrs=4;
			break;
		}
		default:
		{
		empHrs=0;
		}
		}
		totalEmpHrs=totalEmpHrs+empHrs;
		}
	totalSalary=totalEmpHrs*EMP_RATE_PER_HOUR;
	System.out.println("Employee Wage:"+totalSalary);
	}
}
