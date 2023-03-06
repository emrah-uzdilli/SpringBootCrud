<template>
    <div>
        <h2>Customer Registation</h2>
        <form @submit.prevent="save">
            <div class="form-group">
                <label>Customer name</label>
                <input type="text" v-model="customer.customername" class="form-control" placeholder="Customer name">

            </div>
            <div class="form-group">
                <label>Customer Address</label>
                <input type="text" v-model="customer.customeraddress" class="form-control" placeholder="Customer Address">

            </div>
            <div class="form-group">
                <label>Mobile</label>
                <input type="text" v-model="customer.mobile" class="form-control" placeholder="Mobile">

            </div>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
        <form @submit.prevent="updateData">
         
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
        <h2>Customer View</h2>
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Customer Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Mobile</th>
                    <th scope="col">Option</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="customer in result" v-bind:key="customer.id">

                    <td>{{ customer.customerid }}</td>
                    <td>{{ customer.customername }}</td>
                    <td>{{ customer.customeraddress }}</td>
                    <td>{{ customer.mobile }}</td>
                    <td>
                        <button type="button" class="btn btn-warning" @click="edit(customer)">Edit</button>
                        <button type="button" class="btn btn-danger" @click="remove(customer)">Delete</button>
                    </td>
                </tr>

            </tbody>
        </table>

    </div>
</template>
  
<script>
import Vue from 'vue';
import axios from 'axios';
Vue.use(axios)
export default {
    name: 'CustomerCrud',
    data() {
        return {
            result: {},

            customer: {

                customerid: '',
                customername: '',
                customeraddress: '',
                mobile: ''
            }
        }
    },
    created() {
        this.CustomereLoad();
    },
    mounted() {
        console.log("mounted() called.......");

    },
    methods: {
        CustomereLoad() {
            var page = "http://localhost:8084/api/v1/customer/getAllCustomer";
            axios.get(page)
                .then(
                    ({ data }) => {
                        console.log("data",data);
                        this.result = data;
                    }
                );
        },


        save() {
            if (this.customer.customerid == '') {
                this.saveData();
            }
            else {
                this.updateData();
            }
        },
        saveData() {
            axios.post("http://localhost:8084/api/v1/customer/save", this.customer)
                .then(
                    ({ data }) => {
                        alert("saveddddd");
                        this.customer.customerid = '';
                        this.customer.customername = '';
                        this.customer.customeraddress = '',
                            this.customer.mobile = ''
                        this.CustomereLoad();
                    }
                )
        },
        edit(customer) {
            this.customer = customer;

        },
        updateData() {
            var editrecords = 'http://localhost:8084/api/v1/customer/update';
            axios.put(editrecords, this.customer)
                .then(
                    ({ data }) => {
                        this.customer.customerid = '';
                        this.customer.customername = '';
                        this.customer.customeraddress = '',
                            this.customer.mobile = ''
                        this.customerid = ''
                        console.log(this.customer);
                        alert("Updated!!!");
                        this.CustomereLoad();
                    }
                );
        },
        remove(customer) {
            var url = `http://localhost:8084/api/v1/customer/deletecustomer/${customer.customerid}`;
            axios.delete(url);
            alert("Deleteddd");
            this.CustomereLoad();
        }
    }
}
</script>