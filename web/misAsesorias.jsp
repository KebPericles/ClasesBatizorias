<%@page import="basedatos.crud.BDAsesoria"%>
<%@page import="basedatos.crud.BDUsuario"%>
<%@page import="basedatos.entidades.Usuario"%>
<%@page import="basedatos.crud.BDPermisoMateria"%>
<%@page import="basedatos.entidades.PermisoMateria"%>
<%@page import="basedatos.crud.BDMateria"%>
<%@page import="basedatos.entidades.Materia"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="basedatos.conexion.Conexion"%>
<!DOCTYPE html>
<%
    try{
        if (!session.isNew() && (Boolean)session.getAttribute("sesionIniciada") && ((byte)session.getAttribute("tipoUsuario")) == 1) {
            if (BDAsesoria.buscarIdUsuario((String)session.getAttribute("idUsuario")).length>0) {
            
            Usuario u = (Usuario)new BDUsuario().buscarId((String)session.getAttribute("idUsuario"));
            
            String nick = u.getNick();
            String nombre = u.getNombre()+" "+u.getApPat()+" "+u.getApMat();
            String correo = u.getCorreo();
            String municipio = u.getMunicipio();
%>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Tables</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="css/fonts.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="asesores.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-atom"></i>
                </div>
                <div class="sidebar-brand-text mx-3">BATIZOR <sup>2.0</sup></div>
            </a>
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->


            <!-- Divider -->
            <!-- Heading -->
            <div class="sidebar-heading">
                Asesorias
            </div>
            <%
                try{
                    Materia[] materias = BDMateria.todasMaterias();
                    PermisoMateria[] pMaterias = BDPermisoMateria.buscarIdUsuario((String)session.getAttribute("idUsuario"));

                    for (int i = 0; i < materias.length; i++) {                        
                        for (int j = 0; j < pMaterias.length; j++) {
                            if (materias[i].getId().equals(pMaterias[j].getIdMateria())) {
            %>
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Mis Asesorias</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <%
                                if (materias[i].getNombre().equalsIgnoreCase("Algebra")) {
                        %>
                        <form method="POST" action="misAsesorias.jsp">
                            <input type="text" value="algebra" name="materia" hidden>
                            <input type="submit" class="collapse-item btn" value="Algebra">
                        </form>
                        <%
                                }

                                if (materias[i].getNombre().equalsIgnoreCase("Trigonometria")) {
                        %>
                        <form method="POST" action="misAsesorias.jsp">
                            <input type="text" value="trigo" name="materia" hidden>
                            <input type="submit" class="collapse-item btn" value="Trigonometría">
                        </form>
                        <%        
                                }

                                if(materias[i].getNombre().equalsIgnoreCase("Analitica")){
                        %>
                        <form method="POST" action="misAsesorias.jsp">
                            <input type="text" value="analitica" name="materia" hidden>
                            <input type="submit" class="collapse-item btn" value="Geometría analítica">
                        </form>
                        <%
                                }
                        %>
                    </div>
                </div>
            </li>
            <%
                            }
                        }
                    }
                }catch(Exception e){}
            %>
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="crearAsesoria.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Crear asesoria</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
            
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="permisosMateria.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Permisos materia</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=nombre%></span>
                                <i class="fas fa-user-circle"></i>
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="user.jsp">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Perfil
                                </a>

                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> Cerrar sesión
                                </a>
                            </div>
                        </li>
                    </ul>
                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                    <p class="mb-4">tabla con los horarios</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Horarios</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <th width="150" align="center">Num asesoria</th>
                                        <th width="290" align="center">Unidad de aprendizaje</th>
                                    </thead>
                                    <tbody>
                                    <%  //vamos a conectarnos con la BD
                                        Connection con = null;
                                        PreparedStatement st = null;
                                        ResultSet rs = null;
                                        try{
                                            //users es la bd,  user es el usuario root 
                                            int i = 1;
                                            con = Conexion.conectarBD();

                                            String q = "Select * from asesorias where idUsuario = ?";
                                            st = con.prepareStatement(q);
                                            st.setString(1, (String)session.getAttribute("idUsuario"));
                                            rs = st.executeQuery();
                                            //y asi como le hicimos con lo demas hay que recorrer la tabla con un while
                                            while(rs.next()){
                                                //y vamos a hacer que se imprima directo en la tabla
                                     %>

                                     <tr>
                                         <td valign="top" width="80" height="19" ><%=rs.getString(1) %> 

                                         </td>
                                         <td valign="top" width="80" height="19" ><%=rs.getInt("idMateria") %> 
                                         </td>
                                         <td valign="top" width="80" height="19" >
                                             <a href="editar.jsp">  <%=rs.getInt("id") %> </a> 

                                         </td>
                                         <td valign="top" width="80" height="19" >
                                             <a href="borrar.jsp">  <%=rs.getInt("id") %> </a> 

                                         </td>
                                     </tr>
                 
<%
                     i++;
                    //este es de mi whiel
                        }
                        
                        rs.close();
                        st.close();
                        con.close();
                    }catch(Exception e){
                        System.out.println("Si aqui no sirve sout T_T");
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                    }
                
%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2019</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">¿Listo para irte?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
                </div>
                <div class="modal-body">Presiona "Cerrar sesión" si quieres salir de la sesión actual.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                    <a class="btn btn-primary" href="logout.jsp">Cerrar sesión</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>

</html>
<%          }else{
                response.sendRedirect("asesores.jsp");
            }
        }else if (session.isNew()){
            session.invalidate();
            response.sendRedirect("index.html");
        }
    }catch(Exception e){
        response.sendRedirect("index.html");
    }
%>