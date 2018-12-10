<template>
  <b-container fluid>
      <h1>Data Ware House</h1>
    <data-ware-house></data-ware-house>
  </b-container>

</template>
<script>
import DataWareHouse from '@/components/DataWareHouse'

export default {
  name: 'datawareview',
  components: {
    DataWareHouse
  }
}
</script>
