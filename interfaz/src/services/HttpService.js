class HttpService{
    constructor(axios){
        this.axios = axios
        this.urlVivero = 'http://192.168.1.3:8020'
        this.urlDataW = 'http://192.168.1.3:8010/save'
    }
    getAll(){
        return this.axios.get(this.urlVivero)
    }
    getArticulos(){
        return this.axios.get(`${this.urlVivero}/articulo`, this.configMethod('articulos'))
    }
    getClientes(){
        return this.axios.get(`${this.urlVivero}/cliente`, this.configMethod('clientes'))
    }
    getSucursales(){
        return this.axios.get(`${this.urlVivero}/sucursal`, this.configMethod('sucursales'))
    }
    getVendedores(){
        return this.axios.get(`${this.urlVivero}/vendedor`, this.configMethod('vendedores'))
    }
    getVentas(pagina){

        return this.axios.get(`${this.urlVivero}/pagination/?page=${pagina}`, this.configMethod('ventas'))
    }

     //dataWarehouse
    saveCliente(cliente){
        return this.axios.post(`${this.urlDataW}/cliente`, cliente)
    }
    saveProducto(producto){
        return this.axios.post(`${this.urlDataW}/producto`, producto)
    }
    saveSucursal(sucursal){
        return this.axios.post(`${this.urlDataW}/sucursal`, sucursal)
    }
    saveTiempo(tiempo){
        return this.axios.post(`${this.urlDataW}/tiempo`, tiempo)
    }
    saveVendedor(vendedor){
        return this.axios.post(`${this.urlDataW}/vendedor`, vendedor)
    }
    saveVenta(venta){
        return this.axios.post(`${this.urlDataW}/venta`, venta)
    }
    //Obtener ventas del datawarehouse
    getVentaDW(pagina){
        return this.axios.get(`${this.urlDataW}/venta/?page=${pagina}`)
    }
    getVentaAllDW(){
        return this.axios.get(`${this.urlDataW}/ventaAll`)
    }
    configMethod(dato){
        let config = {onDownloadProgress: (progressEvent) => {
            console.log(`Cargando ${dato} ...`)}
        }

        return config
    }



}
export default HttpService
