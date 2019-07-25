package assignment3;

import java.util.Comparator;

class CollectionsSort implements Comparator<Employee>{
	 
    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getSalary() < e2.getSalary()){
            return 1;
        } else {
            return -1;
        }
    }
}

	/*@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return 0;
	}*/