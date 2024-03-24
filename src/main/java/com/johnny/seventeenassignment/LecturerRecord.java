package com.johnny.seventeenassignment;

public final record LecturerRecord(
        String name,
        Integer age,
        Faculty faculty,
        Department dept) {

    public LecturerRecord{
        if(name.isBlank() || age.intValue() < 0){
            // String interpolation
            String errorMsg = """
                    Illegal argument passed:
                        "name": %s,
                        "age": %s
                    """.formatted(name, age);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public boolean hasPhd(){
        String prefix = name.toUpperCase().substring(0, 3);
        String suffix = name.toUpperCase().substring(name.length() - 3);

        return switch(prefix){
            case "DR." -> true;
            default -> switch(suffix){
                case "PHD" -> true;
                default -> false;
            };
        };
    }

    public void whichFaculty(){
        switch(faculty){
            case EngineeringFaculty eng -> {
                System.out.println("Faculty of: " + eng);
                eng.engineering();
            }
            case HumanitiesFaculty hum -> {
                System.out.println("Faculty of: " + hum);
                hum.humanities();
            }
            case BusinessFaculty bus -> {
                System.out.println("Faculty of: " + bus);
                bus.business();
            }
            default -> throw new IllegalArgumentException("Invalid Faculty: " + faculty);
        }
    }

    public void whichDept(){
        switch(dept){
            case ComputerEngineeringDept ce -> {
                System.out.println("Dept of: " + ce);
                ce.compEng();
            }
            case SoftwareEngineeringDept se -> {
                System.out.println("Dept of: " + se);
                se.swEng();
            }
            case SocialCareDept sc -> {
                System.out.println("Dept of: " + sc);
                sc.socialCare();
            }
            case AccountingDept acc -> {
                System.out.println("Dept of: " + acc);
                acc.accounting();
            }
            default -> throw new IllegalArgumentException("Invalid Department: " + dept);
        }
    }
}
