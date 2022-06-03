package com.wfc.jasperlistbeans.service;

import java.util.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service("bean")
public class BeanListService {

    @Autowired
    ResourceLoader resourceLoader;

    public void testBuildPdf() {
        try {
            Map<String, Object> params = new HashMap<>();
            JasperReport jasperReport = JasperCompileManager.compileReport(resourceLoader.getResource("classpath:bean_list.jrxml").getInputStream());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, getDataSource());

            JasperExportManager.exportReportToPdfFile(jasperPrint, "beanlist.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JRDataSource getDataSource() {
        Collection<BeanWithList> coll = new ArrayList<>();
        coll.add(new BeanWithList(Arrays.asList("London", "Paris"), 1));
        coll.add(new BeanWithList(Arrays.asList("London", "Madrid", "Moscow"), 2));
        coll.add(new BeanWithList(Arrays.asList("Rome"), 3));
        coll.add(new BeanWithList(Arrays.asList("São Paulo", "Campinas"), 4));

        return new JRBeanCollectionDataSource(coll);
    }
}
