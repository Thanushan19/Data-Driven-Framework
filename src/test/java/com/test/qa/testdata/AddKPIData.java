package com.test.qa.testdata;

import com.test.qa.utils.ExcelDataConfig;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class AddKPIData extends ExcelDataConfig{
    private static final Logger LOGGER = Logger.getLogger(AddKPIData.class);

    public AddKPIData() {
        super("src\\test\\resources\\ExcelSheet\\AddKPI.xlsx");
    }

    @DataProvider(name = "KPIAddExcel")
    public Object[][] KPIAddExcel() {

        int rows = getRowCount("KPI");
        int col = getColumnCount("KPI");


        LOGGER.info("row = " + rows + " columns = " + col);

        Object[][] data = new Object[rows][col];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = getData("KPI", i, j);
            }
        }
        return data;
    }

}
