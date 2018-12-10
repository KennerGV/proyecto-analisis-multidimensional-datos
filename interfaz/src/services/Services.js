import Axios from 'axios'
import httpService from './HttpService'

Axios.defaults.headers.common.Accept2 = 'application/json'

export default {
  httpService: new httpService(Axios)
}
