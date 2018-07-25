<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
       <ul class="collapsible collapsible-accordion">
          <li>
            <a class="collapsible-header indigo">Calander<i class="material-icons">arrow_drop_down</i></a>
              <div class="collapsible-body">
                <ul>
                    <li>
                        <a href="<s:url value="/crypto/cal_view"/>" class="light-green lighten-2" >
                                    view<i class="material-icons">arrow_forward</i></a>
                    </li>
                    <li>
                        <a href="<s:url value="/crypto/cal_create"/>" class="indigo lighten-2" >
                                    create entry<i class="material-icons">arrow_forward</i></a>
                    </li>
                </ul>  
              </div>
          </li>
      </ul>
</body>
</html>