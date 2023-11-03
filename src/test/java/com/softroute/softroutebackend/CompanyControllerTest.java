package com.softroute.softroutebackend;

import com.softroute.softroutebackend.softroute.company.api.CompanyController;
import com.softroute.softroutebackend.softroute.company.domain.model.Company;
import com.softroute.softroutebackend.softroute.company.domain.service.CompanyService;
import com.softroute.softroutebackend.softroute.company.mapping.CompanyMapper;
import com.softroute.softroutebackend.softroute.company.resource.CompanyResource;
import com.softroute.softroutebackend.softroute.company.resource.CreateCompanyResource;
import com.softroute.softroutebackend.softroute.company.resource.UpdateCompanyResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CompanyControllerTest {

    @Mock
    private CompanyService companyService;

    @Mock
    private CompanyMapper mapper;

    @InjectMocks
    private CompanyController companyController;

    @Test
    public void testGetAllCompanies() {
        // Mock data
        List<CompanyResource> mockCompanies = Collections.singletonList(new CompanyResource());
        when(companyService.getAll()).thenReturn(Collections.emptyList());
        when(mapper.modelList(Collections.emptyList())).thenReturn(mockCompanies);

        List<CompanyResource> result = companyController.getAllCompanies();
        assertEquals(1, result.size());
    }

    @Test
    public void testGetCompanyById() {
        // Mock data
        Long companyId = 1L;
        CompanyResource mockCompany = new CompanyResource();
        when(companyService.getById(companyId)).thenReturn(new Company());
        when(mapper.toResource(any(Company.class))).thenReturn(mockCompany);

        CompanyResource result = companyController.getCompanyById(companyId);
        assertEquals(mockCompany, result);
    }

    @Test
    public void testCreateCompany() {
        // Mock data
        CreateCompanyResource createCompanyResource = new CreateCompanyResource();
        CompanyResource mockCompany = new CompanyResource();
        when(mapper.toModel(createCompanyResource)).thenReturn(new Company());
        when(companyService.create(any(Company.class))).thenReturn(new Company());
        when(mapper.toResource(any(Company.class))).thenReturn(mockCompany);

        CompanyResource result = companyController.createCompany(createCompanyResource);
        assertEquals(mockCompany, result);
    }


}

