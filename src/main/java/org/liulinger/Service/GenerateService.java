package org.liulinger.Service;

public interface GenerateService {
    void doGenerate(String uidStart, int numbers, int permission);
    String getSuccessMessage();
}
