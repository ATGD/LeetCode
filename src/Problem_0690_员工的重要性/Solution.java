package Problem_0690_员工的重要性;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) map.put(employee.id, employee);
        int importance = 0;
        importance += getImportanceToNext(map, id);
        return importance;
    }

    private int getImportanceToNext(Map<Integer, Employee> map, int id) {
        Employee tmpEmp = map.get(id);
        int tempImp = tmpEmp.importance;
        if (tmpEmp.subordinates != null)
            for (int subordinateId : tmpEmp.subordinates) tempImp += getImportanceToNext(map, subordinateId);
        return tempImp;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
