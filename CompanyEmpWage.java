import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

 interface IComputeEmpWage{
    public void addCompanyEmpWage(String company,int empRatePerHr, int numOfWorkingDays,int MaxHoursPerMonth);
    public void computeEmpWage();
    public int getTotalWage(String company);
}

public class CompanyEmpWage {
    public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public  int totalEmpWage;

    public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
        totalEmpWage=0;
    }
    public void setTotalEmpWage(int totalEmpWage){
        this.totalEmpWage=totalEmpWage;
    }
    public  String toString(){
        return "Total Emp Wage for Company: " +company+" is :"+totalEmpWage;
    }
    
}
class EmpWageBuilder implements IComputeEmpWage{
    public static final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;
    private int numOfCompany=0;
    private LinkedList<CompanyEmpWage> companyEmpWageList;
    private Map<String,CompanyEmpWage> companyEmpWageMap;

    public EmpWageBuilder(){
        companyEmpWageList=new LinkedList<>();
        companyEmpWageMap=new HashMap<>();
    }
    @Override
    public void addCompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHourPerMonth) {
    CompanyEmpWage companyEmpWage=new CompanyEmpWage(company,empRatePerHr,numOfWorkingDays,maxHourPerMonth);
    companyEmpWageList.add(companyEmpWage);
    companyEmpWageMap=new HashMap<>();
    }

    @Override
    public void computeEmpWage() {
    for(int i=0;i<companyEmpWageList.size();i++){
        CompanyEmpWage companyEmpWage=companyEmpWageList.get(i);
        companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
        System.out.println(companyEmpWage);
    }
    }

    @Override
    public int getTotalWage(String company) {
        return companyEmpWageMap.get(company).totalEmpWage;
    }
    public int computeEmpWage (CompanyEmpWage companyEmpWage){
        final int IS_PART_TIME=1;
        final int IS_FULL_TIME=2;
        int empWage=0;
        int empHrs=0;
        int totalEmpHrs=0;
        int totalWorkingDays=0;
        int totalSalary;;
        while(totalEmpHrs<companyEmpWage.maxHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays)
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
        totalSalary=totalEmpHrs*companyEmpWage.empRatePerHour;
        System.out.println("Employee Wage:"+totalSalary);
        return totalSalary;
    }
    public static void main(String[] args){
        IComputeEmpWage empWageBuilder =new EmpWageBuilder();
        empWageBuilder.addCompanyEmpWage("Dmart",20,2,10);
        empWageBuilder.addCompanyEmpWage("Amazon",10,4,20);
        empWageBuilder.computeEmpWage();
        System.out.println("Total Wage for Dmart Company: "+empWageBuilder.getTotalWage("Amazon"));
    }
}

