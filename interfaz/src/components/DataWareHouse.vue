<template>
<div v-if="ventas != null">
  <b-row>
    <b-col class="bg-secondary text-white">
      <b-form-group label-class="font-weight-bold" label="Tiempos">
        <b-form-checkbox id="checkboxDia" v-model="dia">Dia</b-form-checkbox>
        <b-form-checkbox id="checkboxMes" v-model="mes">Mes</b-form-checkbox>
        <b-form-checkbox id="checkboxAno" v-model="ano">Año</b-form-checkbox>
      </b-form-group>
    </b-col>

    <b-col class="bg-secondary text-white mx-2">
      <b-form-group label-class="font-weight-bold" label="Productos">
        <b-form-checkbox id="checkboxidProducto" v-model="idProducto">Id producto</b-form-checkbox>
        <b-form-checkbox id="checkboxnombreProducto" v-model="nombreProducto">Nombre producto</b-form-checkbox>
        <b-form-checkbox id="checkboxfamiliaProducto" v-model="familiaProducto">Familia</b-form-checkbox>
      </b-form-group>

    </b-col>

    <b-col class="bg-secondary text-white">
      <b-form-group label-class="font-weight-bold" label="Sucursal">
        <b-form-checkbox id="checkboxnombreSucursal" v-model="nombreSucursal">Nombre</b-form-checkbox>
        <b-form-checkbox id="checkboxnombreRegion" v-model="nombreRegion">Region</b-form-checkbox>
        <b-form-checkbox id="checkboxnombreComunidad" v-model="nombreComunidad">Comunidad</b-form-checkbox>
      </b-form-group>
    </b-col>

  </b-row>

  <b-row>
    <b-col class="bg-secondary text-white mt-2">
      <b-form-group label-class="font-weight-bold" label="Cliente">
        <b-form-checkbox id="checkboxidCliente" v-model="idCliente">ID</b-form-checkbox>
        <b-form-checkbox id="checkboxnombreCliente" v-model="nombreCliente">Nombre</b-form-checkbox>
        <b-form-checkbox id="checkboxestadoCivil" v-model="estadoCivil">Estado civil</b-form-checkbox>
        <b-form-checkbox id="checkboxEdad" v-model="edad">Edad</b-form-checkbox>
      </b-form-group>
    </b-col>
    <b-col class="bg-secondary text-white mx-2 mt-2">
      <b-form-group label-class="font-weight-bold" label="Vendedor">
        <b-form-checkbox id="checkboxidVendedor" v-model="idVendedor">ID</b-form-checkbox>
        <b-form-checkbox id="checkboxnombreVendedor" v-model="nombreVendedor">Nombre</b-form-checkbox>
        <b-form-checkbox id="checkboxtipoCapacita" v-model="tipoCapacitacion">Tipo de capacitación</b-form-checkbox>
        <b-form-checkbox id="checkboxHoraCapacita" v-model="horaCapacitacion">Horas de capacitación</b-form-checkbox>

      </b-form-group>
    </b-col>
    <b-col class="bg-secondary text-white mt-2">
      <b-form-group label-class="font-weight-bold" label="Venta">
        <b-form-checkbox id="checkboxcantidadVenta" v-model="cantidadVenta">Cantidad vendidos</b-form-checkbox>
        <b-form-checkbox id="checkboxmontoVenta" v-model="montoVenta">Monto vendido</b-form-checkbox>
      </b-form-group>
    </b-col>
  </b-row>

  <b-button class="m-2" variant="success" @click="cargarDatosExportar()">Cargar datos a exportar</b-button>
  <download-excel
    class   = "btn btn-primary"
    :data   = "ventasExport"
    name    = "datawarehouse.xls" v-if="ventasExport.length != 0">
    Exportar datos a excel
  </download-excel>

  <b-row class="justify-content-center my-3" v-if="ventasExport.length != 0">
    <b-col cols="4">
      <b-pagination align="center" :total-rows="totalRows" :per-page="perPage" v-model="currentPage" class="my-0" />
    </b-col>
    </b-row>
    <b-table striped hover
            :items="ventasExport"
            :fields="fieldsExport"
            :current-page="currentPage"
             :per-page="perPage">
    </b-table>

   </div>

</template>

<script>
export default {
  name: 'DataWareHouse',
  mounted () {
    this.cargarAll()
  },
  data () {
    return {
      ventas: null,
      currentPage: 1,
      perPage: 100,
      totalRows: 0,
      ventasExport: [],
      fieldsExport: [],
      dia: false,
      mes: false,
      ano: false,
      idProducto: false,
      nombreProducto: false,
      familiaProducto: false,
      nombreSucursal: false,
      nombreRegion: false,
      nombreComunidad: false,
      idCliente: false,
      nombreCliente: false,
      estadoCivil: false,
      edad: false,
      idVendedor: false,
      nombreVendedor: false,
      tipoCapacitacion: false,
      horaCapacitacion: false,
      cantidadVenta: false,
      montoVenta: false,
      cargados: 0
    }
  },
  methods: {
    cargarAll: async function () {
      let httpServices = this.$store.state.services
      try {
        const ventas = await httpServices.httpService.getVentaAllDW()
        this.ventas = ventas.data
        this.totalRows = ventas.data.length
        console.log('todo cargado')
      } catch (error) {
        console.log('error consultado ventas')
      }
    },
    cargarDatosExportar: function () {
      this.ventasExport = []
      this.fieldsExport = []
      this.json_fields = {}
      console.log('change')
      this.ventas.forEach(venta => {
        let arreglo = {}
        if (this.dia) {
          arreglo.dia = venta.tiempo.dia
        }
        if (this.mes) {
          arreglo.mes = venta.tiempo.mes
        }
        if (this.ano) {
          arreglo.ano = venta.tiempo.ano
        }
        // Datos de producto
        if (this.idProducto) {
          arreglo.idProducto = venta.producto.idProducto
        }
        if (this.nombreProducto) {
          arreglo.nombreProducto = venta.producto.nombreProducto
        }
        if (this.familiaProducto) {
          arreglo.familiaProducto = venta.producto.familiaProducto
        }
        // Datos de sucursal
        if (this.nombreSucursal) {
          arreglo.nombreSucursal = venta.sucursal.nombreSucursal
        }
        if (this.nombreRegion) {
          arreglo.nombreRegion = venta.sucursal.nombreRegion
        }
        if (this.nombreComunidad) {
          arreglo.nombreComunidad = venta.sucursal.nombreComuna
        }

        // datos del cliente
        if (this.idCliente) {
          arreglo.idCliente = venta.cliente.idCliente
        }
        if (this.nombreCliente) {
          arreglo.nombreCliente = venta.cliente.nombreCliente
        }
        if (this.estadoCivil) {
          arreglo.estadoCivilCliente = venta.cliente.estadoCivil
        }
        if (this.edad) {
          arreglo.edadCliente = venta.cliente.edadCLiente
        }

        // datos del vendedor
        if (this.idVendedor) {
          arreglo.idVendedor = venta.vendedor.idVendedor
        }
        if (this.nombreVendedor) {
          arreglo.nombreVendedor = venta.vendedor.nombreVendedor
        }
        if (this.tipoCapacitacion) {
          arreglo.tipoCapacitacionVendedor = venta.vendedor.tipoCapacitacion
        }
        if (this.horaCapacitacion) {
          arreglo.horaCapacitacionVendedor = venta.vendedor.horaCapacitacion
        }
        // venta
        if (this.cantidadVenta) {
          arreglo.cantidadProductosVendidos = venta.cantidadVenta
        }
        if (this.montoVenta) {
          arreglo.montoVendido = venta.montoVenta
        }

        this.cargados++
        this.ventasExport.push(arreglo)
      })

      Object.keys(this.ventasExport[0]).forEach(field => {
        if (field === 'dia') {
          this.fieldsExport.push('dia')
        }
        if (field === 'mes') {
          this.fieldsExport.push('mes')
        }
        if (field === 'ano') {
          this.fieldsExport.push({ key: 'ano', label: 'Año' })
        }
        if (field === 'idProducto') {
          this.fieldsExport.push('idProducto')
        }
        if (field === 'nombreProducto') {
          this.fieldsExport.push({ key: 'nombreProducto', sortable: true })
        }
        if (field === 'familiaProducto') {
          this.fieldsExport.push('familiaProducto')
        }
        if (field === 'nombreSucursal') {
          this.fieldsExport.push('nombreSucursal')
        }
        if (field === 'nombreRegion') {
          this.fieldsExport.push('nombreRegion')
        }
        if (field === 'nombreComunidad') {
          this.fieldsExport.push('nombreComunidad')
        }

        // datos del cliente
        if (field === 'idCliente') {
          this.fieldsExport.push('idCliente')
        }
        if (field === 'nombreCliente') {
          this.fieldsExport.push('nombreCliente')
        }
        if (field === 'estadoCivilCliente') {
          this.fieldsExport.push('estadoCivilCliente')
        }
        if (field === 'edadCliente') {
          this.fieldsExport.push('edadCliente')
        }

        if (field === 'idVendedor') {
          this.fieldsExport.push('idVendedor')
        }
        if (field === 'nombreVendedor') {
          this.fieldsExport.push('nombreVendedor')
        }
        if (field === 'tipoCapacitacionVendedor') {
          this.fieldsExport.push('tipoCapacitacionVendedor')
        }
        if (field === 'horaCapacitacionVendedor') {
          this.fieldsExport.push('horaCapacitacionVendedor')
        }

        if (field === 'cantidadProductosVendidos') {
          this.fieldsExport.push('cantidadProductosVendidos')
        }
        if (field === 'montoVendido') {
          this.fieldsExport.push('montoVendido')
        }
      })
    }
  }
}
</script>
