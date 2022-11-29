$(document).ready(function () {
    const tabla = $('#tabla-productos').DataTable(
        {

            ajax: {
                url: 'http://localhost:8080/api/producto/listar',
                type: 'GET',
                dataSrc: function (json) {
                    return json;
                }
            },
            columns: [
                {data: "id"},
                {data: "codigo"},
                {data: "nombre"},
                {data: "marca"},
                {data: "modelo"},
                {data: "valor"},
                {data: "cantidad"},
                {data: "descripcion"},
                {data: "urlImagen"},
                {data: "categoria.nombre"},
                {
                    defaultContent: '<button  id="btneditar" class="btn btn-success editar"  ><i class="bi bi-pencil"></i></button> <button class="btn btn-danger" id="btneliminar" type="button"><i class="bi bi-trash"></i></button>'
                }
            ],
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por pagina",
                "zeroRecords": "Nothing found - sorry",
                "info": " Pagina actual _PAGE_ de _PAGES_",
                "infoEmpty": "No hay registros",
                "infoFiltered": "(Encontrados de _MAX_ Registros)",
                "search": "Buscar:",
                "paginate": {
                    "first": "Primero",
                    "last": "Ultimo",
                    "next": "Siguiente",
                    "previous": "Anterior"
                },
            },



        });

    $("#tabla-productos tbody").on('click','#btneliminar',function (e) {
        let tr = $(this).closest('tr');
        let row = tabla.row(tr).data();

        console.log("eliminar",row);
    })


    $("#tabla-productos tbody").on('click','#btneditar',function (e) {
        let tr = $(this).closest('tr');
        let row = tabla.row(tr).data();

        console.log("editar",row);
    })



    function eliminar(producto) {
        const confr = confirm("Esta seguro que desea elimianar el producto\n"
            + producto.descripcion);
        if (confr) {
            $.ajax({
                url: "http://localhost:8080/api/producto/eliminar/" + producto.id,
                type: "DELETE",
                //data: {id: producto.id},
                success: function (respuesta) {


                }
            });
            alert("Producto eliminado");

            location.reload();

        } else {
            alert("operacion cancelada");
        }

    }

    function editar(data) {
        console.log(data);
        localStorage.setItem("producto", JSON.stringify(data));

        document.location.href = "http://localhost:8080/producto/editar.html";

    }


});
