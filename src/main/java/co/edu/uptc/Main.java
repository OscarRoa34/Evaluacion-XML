package co.edu.uptc;

import co.edu.uptc.controllers.FileController;
import co.edu.uptc.controllers.WriteFiles;
import co.edu.uptc.services.FilterService;

public class Main {
    public static void main(String[] args) {
        FileController fc = new FileController();
        FilterService fs = new FilterService(fc.leer());
        WriteFiles wf = new WriteFiles(fs);

        wf.writeMinorSalaryFile();
        wf.writeGreatSalaryFile();
    }
}
