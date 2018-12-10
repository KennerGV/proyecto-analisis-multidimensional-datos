<template>
<b-container>
  <b-row>
    <b-col>
      <h1>{{msg}}</h1>
    </b-col>
  </b-row>
  <b-row>
    <b-col>
      <!-- <b-table striped hover :items="ventas"></b-table> -->
      <h5>Productos: {{producto}}</h5>
      <h5>Clientes: {{cliente}}</h5>
    </b-col>
    <b-col>
      <h5>Sucursales: {{sucursal}}</h5>
      <h5>Vendedores: {{vendedor}}</h5>
    </b-col>
    <b-col>
      <h5>Tiempos: {{tiempo}}</h5>
      <h5>Ventas: {{venta}}</h5>
    </b-col>
  </b-row>
  <b-row class="mt-4">
    <b-col>
      <b-button variant="danger">Vaciar datawarehouse</b-button>
      <b-button variant="success" @click="cargar()" class="ml-2">Extraer e insertar datos a datawarehouse</b-button>
    </b-col>
  </b-row>
</b-container>
</template>

<script>
export default {
  name: "Vivero",
  props: {
    msg: String
  },
  data() {
    return {
      ventas: [],
      contenido: [],
      producto: 0,
      cliente: 0,
      sucursal: 0,
      vendedor: 0,
      tiempo: 0,
      venta: 0,

    }
  },
  methods: {

    cargar: async function() {
      let httpServices = this.$store.state.services
      try {
        const productosP = httpServices.httpService.getArticulos()
        const clientesP = httpServices.httpService.getClientes()
        const sucursalesP = httpServices.httpService.getSucursales()
        const vendedoresP = httpServices.httpService.getVendedores()

        const [
          productos,
          clientes,
          sucursales,
          vendedores,

        ] = await Promise.all([
          productosP,
          clientesP,
          sucursalesP,
          vendedoresP,

        ])

        await Promise.all([
          insertarProductos(productos.data, this),
          insertarClientes(clientes.data, this),
          insertarSucursales(sucursales.data, this),
          insertarVendedores(vendedores.data, this)
        ])


        for(let i = 0; i<=20; i++){
          const ventas = await httpServices.httpService.getVentas(i)
          await insertarTiempos(ventas.data.content, this)
          await insertarVentas(ventas.data.content, this)
        }


        function insertarTiempos(ventas, self) {
          ventas.forEach(venta => {
            let fecha = venta.fecha.split("-")
            let ano = fecha[0]
            let mes = fecha[1]
            let diaHora = fecha[2]

            let tiempo = {
              idTiempo: venta.id,
              dia: diaHora.charAt(0) + diaHora.charAt(1),
              mes: mes,
              ano: ano
            }

            httpServices.httpService.saveTiempo(tiempo)
            self.tiempo++
          })
        }
        function insertarVentas (ventas, self) {
          ventas.forEach(venta => {
            let ventaInsert = {
              idVenta: venta.id,
              producto: {
                idProducto: venta.documento.codigoProducto.codigoProducto
              },
              sucursal: { idSucursal: venta.sucursalId },
              cliente: { idCliente: venta.idCliente },
              vendedor: { idVendedor: venta.idVendedor },
              tiempo: { idTiempo: venta.id },
              cantidadVenta: venta.documento.cantidad,
              montoVenta: venta.documento.total
            }

            httpServices.httpService.saveVenta(ventaInsert);
            self.venta++
          })
        }
        function insertarProductos (productos, self) {
          productos.forEach(producto => {
            let productoInsert = {
              idProducto: producto.codigoProducto,
              nombreProducto: producto.nombre,
              familiaProducto: producto.familia
            }
            httpServices.httpService.saveProducto(productoInsert)
            self.producto++
          })
        }
        function insertarClientes (clientes, self) {
          clientes.forEach(cliente => {
            let clienteInsert = {
              idCliente: cliente.idCliente,
              nombreCliente: cliente.nombre,
              edadCliente: cliente.edad,
              estadoCivil: cliente.estadoCivil
            }
            httpServices.httpService.saveCliente(clienteInsert)
            self.cliente++
          })
        }

        function insertarSucursales (sucursales, self) {
          sucursales.forEach(sucursal => {
            let sucursalInsert = {
              idSucursal: sucursal.sucursalId,
              nombreSucursal: sucursal.nombreSucursal,
              nombreRegion: sucursal.ciudadId.provinciaId.region.region,
              nombreComuna: sucursal.ciudadId.ciudadNombre
            }

            httpServices.httpService.saveSucursal(sucursalInsert)
            self.sucursal++
          })
        }
        function insertarVendedores (vendedores, self) {
          vendedores.forEach(vendedor => {
            let vendedorInsert = {
              idVendedor: vendedor.idVendedor,
              nombreVendedor: vendedor.nombre,
              tipoCapacitacion: vendedor.tipoCapacitacion,
              horaCapacitacion: vendedor.horasCapacitacion
            }
            httpServices.httpService.saveVendedor(vendedorInsert)
            self.vendedor++
          })
        }
      } catch (error) {
        console.log(error)
      }
    }
  }
  }
</script>

<style scoped>

</style>
