import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  product: Product;
  id: number;
  categories: Category[] = []
  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private route: Router,
              private categoryService: CategoryService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });
  }

  ngOnInit(): void {
    this.getCategory();
  }

  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.product = product;
      this.productForm = new FormGroup({
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description),
        category: new FormControl(product.category)
      });
    });
  }
  submit(id: number) {
    const product = this.productForm.value ;
    this.productService.updateProduct(id, product).subscribe(() => {
      alert('Successful!');
      this.backtolist();
    }, error => {
      alert('Failed!') ;
    });
  }

  getCategory() {
    this.categoryService.getAll().subscribe(category => {
      this.categories = category;
    });
  }

  backtolist() {
    this.route.navigateByUrl('product/list');
  }
}
