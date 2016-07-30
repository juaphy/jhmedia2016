package com.jhmedia.master.web.common.interceptor;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author phu
 */
@Repository
public class LoginInterceptor extends HandlerInterceptorAdapter {
  private static final String[] NO_FILTERS = new String[] {
      "/personinfo.html",
      "/enterpriseinfo.html",
      "/edit_enterpriseinfo.html",
      
      
  };

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

	  String uri = request.getRequestURI();

	  if("/".equals(uri)){
		  response.sendRedirect("/login");
	      return false;
	  }
	 /* Account account=(Account)request.getSession().getAttribute(Const.SESSION_USER);
	  for (String noFilter : NO_FILTERS) {
		  if (uri.startsWith(noFilter)&&account==null) {
			  response.sendRedirect("/toLogin");
			  return false;
		  }
	  }*/

	  /*if (request.getSession().getAttribute(Const.SESSION_USER) == null) {
      response.sendRedirect("/toLogin");
      return false;
    }*/

	  return true;
  }
  
}
