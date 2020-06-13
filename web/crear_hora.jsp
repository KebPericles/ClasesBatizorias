<!DOCTYPE html>
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

    <%
           String DRIVER = "com.mysql.jdbc.Driver";
                    Class.forName(DRIVER).newInstance();
                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;
                    int a=0;
                    try{
                        String url="jdbc:mysql://localhost:3306/batizorias?user=root&password=n0m3l0";
                        //users es la bd,  user es el usuario root 
                        int i = 1;
                        con = DriverManager.getConnection(url);
                        st = con.createStatement();
                        String q = "Select* from asesorias where idusuario ='?'";
                        rs = st.executeQuery(q);
                        while(rs.next()){
                         a+=1;
                        }
                        con.close();
                        st.close();
                        rs.close();
                    }
                    catch(SQLException ex){
                     out.println("hola");
                     out.println(ex.getStackTrace());
                     out.println(ex);
                     con.close();
                     st.close();
                     rs.close();

                    }catch(Exception e){
                     out.println("hola2");
                     out.println(e.getStackTrace());
                     out.println(e);
                     con.close();
                     st.close();
                     rs.close();
                    
                    }finally{
                    con.close();
                    st.close();
                    rs.close();
                    }%>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-atom"></i>
                </div>
                <div class="sidebar-brand-text mx-3">BATIZOR <sup>2.0</sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>ACTIVIDAD</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->


            <!-- Divider -->
            <!-- Heading -->
            <div class="sidebar-heading">
                Addons
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Mis Asesorias</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">

                        <a class="collapse-item" href="blank.html">Algebra</a>
                        <a class="collapse-item" href="blank.html">Trigo</a>
                        <a class="collapse-item" href="blank.html">Analiitica</a>

                    </div>
                </div>
            </li>


            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Charts</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="buscarAsesorias.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Buscar Asesorias</span></a>
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

                    <!-- Topbar Search -->
                    <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - Alerts -->
                            <!-- Dropdown - Alerts -->
                            

                        <!-- Nav Item - User Information -->
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
                                    <tr>
                <td width="100%" >
                    <form method="post" action="guardar_hora.jsp" >
                        <h2>
                            Datos a Insertar
                        </h2>
                        <table border="1" width="100%" >
                            <tr>
                                <td width="50%" >
                                    <b>
                                        id asesoria
                                    </b>
                                </td>
                                <td width="50%" >
                                    <input type="text" name="id" id="id" >
                                    </td>
                            </tr>
                             <tr>
                                <td width="50%" >
                                    <b>
                                        horario
                                    </b>
                                </td>
                                <td width="50%" >
                                    <select id="hora" name="hora" >
                                        <option value=80000>8</option>
                                        <option value=90000>9</option>
                                        <option value=100000>10</option>
                                        <option value=110000>11</option>
                                    </select>

                                    </td>
                            </tr>
                             <tr>
                                <td width="50%" >
                                    <b>
                                        Dias
                                    </b>
                                </td>
                                <td width="50%" >
                                        <select id="dias" name="dias" >
                                        <option value="L">Lunes</option>
                                        <option value='M'>Martes</option>
                                        <option value='X'>Miercoles</option>
                                        <option value='J'>Jueves</option>
                                        <option value='V'>viernes</option>
                                    </select>

                                </td>
                            </tr>
                             
                             <tr>
                                <td width="50%" >
                                    <b>
                                        duracion
                                    </b>
                                </td>
                                <td width="50%" >
                                    <input type="text"
                                           name="duracion" >
                                </td>
                            </tr>
                        </table>
                        
                        <input type="submit" value="Agregar horario" >
                        <input type="reset" value="Borrar Datos" >
                            
                    </form>
                </td>
            </tr>
        </table>
        <%} %>
            
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
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
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
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>

</html>