'use strict'

let app = new Vue({
    el: '#app',
    data: {
        products: []
    },
    methods: {
        getProdutcs: function () {
            let that = this;
            axios.get('/products')
                .then(res => {
                    that.products = res.data;
                })
                .catch(err => {
                    console.log(err);
                    alert('error occurred!');
                });
        }
    },
    mounted: function () {
        this.getProdutcs();
    }
});