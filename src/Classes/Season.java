/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Steve
 */
public class Season {
    
    private String code;
    private String EntryDate;
    private String ExitDate;
    private String Name;

    public Season(String code, String EntryDate, String ExitDate, String Name) {
        this.code = code;
        this.EntryDate = EntryDate;
        this.ExitDate = ExitDate;
        this.Name = Name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(String EntryDate) {
        this.EntryDate = EntryDate;
    }

    public String getExitDate() {
        return ExitDate;
    }

    public void setExitDate(String ExitDate) {
        this.ExitDate = ExitDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
    
    
    
    
    
    
    
}