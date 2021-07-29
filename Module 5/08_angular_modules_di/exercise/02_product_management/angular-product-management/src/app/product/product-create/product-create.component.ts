import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categories: Category[] = [] ;
  productForm: FormGroup ;
  constructor(private productService: ProductService, private categoryService: CategoryService) {
    this.productForm  = new FormGroup({
      name: new FormControl(),
      price: new FormControl(),
      description: new FormControl(),
      category: new FormControl()
    });
  }

  ngOnInit(): void {
    this.getAll();
  }
  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product).subscribe( () => {
      this.productForm.reset();
      alert('Successful!');
    }, error => {
      alert('Failed!') ;
    });
  }
  getAll() {
    this.categoryService.getAll().subscribe(category => {
      this.categories = category;
    });
  }
}
