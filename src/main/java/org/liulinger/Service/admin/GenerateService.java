package org.liulinger.Service.admin;

public interface GenerateService {
    void doGenerate(String uidStart, int numbers, int permission);
    String getSuccessMessage();
}
