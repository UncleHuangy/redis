package com.nba.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nba.domain.Province;
import com.nba.service.Impl.ProvinceServiceImpl;
import com.nba.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/findProvinceServlet")
public class findProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProvinceService service = new ProvinceServiceImpl();
        String province_json = service.findJedisProvinve();

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(province_json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
