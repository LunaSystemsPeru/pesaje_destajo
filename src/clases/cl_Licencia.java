/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.apache.poi.ss.formula.ptg.ExpPtg;

/**
 *
 * @author Luis
 */
public class cl_Licencia {

    public cl_Licencia() {
    }

    private String serial(int typo) {
        // wmic command for diskdrive id: wmic DISKDRIVE GET SerialNumber
        // wmic command for cpu id : wmic cpu get ProcessorId
        Process process = null;
        String[] options = new String[4];
        if (typo == 1) {
            options = new String[]{"wmic", "bios", "get", "SerialNumber"};
        }
        if (typo == 2) {
            options = new String[]{"wmic", "DISKDRIVE", "get", "SerialNumber"};
        }
        if (typo == 3) {
            options = new String[]{"wmic", "cpu", "get", "ProcessorId"};
        }
        if (typo == 4) {
            options = new String[]{"wmic", "baseboard", "get", "SerialNumber"};
        }

        try {
            process = Runtime.getRuntime().exec(options);
            process.getOutputStream().close();
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next();
        //    System.out.println(property + ": " + serial);
        return serial;
    }

    public String getSerial() {
        String serialbios = this.serial(1);
        String serialdisk = this.serial(2);
        return serialbios + serialdisk;
    }
}
