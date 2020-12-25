package com.cenozoic.number.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p> 跨域
 *
 * @author xucaifeng
 * @since 2020-12-19
 **/
@Slf4j
@Component
@WebFilter(filterName="corsFilter", urlPatterns="/*")
public class CORSFilter implements Filter {

	public static String VALID_METHODS = "DELETE, HEAD, GET, OPTIONS, POST, PUT";

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) res;
        // No Origin header present means this is not a cross-domain request
        String origin = httpReq.getHeader("Origin");
         if (origin == null) {
            // Return standard response if OPTIONS request w/o Origin header
           if ("OPTIONS".equalsIgnoreCase(httpReq.getMethod())) {
                httpResp.setHeader("Allow", VALID_METHODS);
                httpResp.setStatus(200);
                return;
            }
        } else {
            // This is a cross-domain request, add headers allowing access
            httpResp.setHeader("Access-Control-Allow-Origin", origin);
            httpResp.setHeader("Access-Control-Allow-Methods", VALID_METHODS);
            httpResp.setHeader("Access-Control-Allow-Credentials", "true");
            
            String headers = httpReq.getHeader("Access-Control-Request-Headers");
            if (headers != null)
                httpResp.setHeader("Access-Control-Allow-Headers", headers);

            // Allow caching cross-domain permission
            httpResp.setHeader("Access-Control-Max-Age", "360000");
        }
        // Pass request down the chain, except for OPTIONS
        if (!"OPTIONS".equalsIgnoreCase(httpReq.getMethod())) {
            chain.doFilter(req, res);
        }
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
    public void destroy() {

    }

}
