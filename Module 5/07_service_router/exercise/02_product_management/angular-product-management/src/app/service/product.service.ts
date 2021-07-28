import { Injectable } from '@angular/core';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12 Pro Max',
    price: 30000000,
    description: 'High-end Phone'
  }, {
    id: 2,
    name: 'Samsung Galaxy Fold 2',
    price: 35000000,
    description: 'Fold-able Phone'
  }, {
    id: 3,
    name: 'Oppo Find X',
    price: 8000000,
    description: 'Great Camera Quality'
  }, {
    id: 4,
    name: 'Xiaomi Mi 12',
    price: 15000000,
    description: 'Cheap High-end Phone'
  }];

  constructor() { }
  getAll() {
    return this.products;
  }

  saveProduct(product) {
    this.products.push(product);
  }

  editProduct(product: Product) {
    for (let i = 0 ; i < this.products.length ; i++) {
      if (this.products[i].id  === product.id) {
        this.products[i] = product;
        break;
      }
    }
  }

  deleteProduct(id: number) {
    for (let i = 0 ; i < this.products.length ; i++) {
      if (this.products[i].id === id) {
        this.products.splice(i, 1) ;
        break;
      }
    }
  }
  getProductById(id: number): Product {
    console.log(id);
    for (let i = 0 ; i < this.products.length ; i++) {
      if (this.products[i].id === id) {
        return this.products[i] ;
      }
    }
    return null;
  }
}
