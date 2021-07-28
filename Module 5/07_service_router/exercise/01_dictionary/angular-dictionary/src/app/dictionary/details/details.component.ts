import { Component, OnInit } from '@angular/core';
import {IWord} from '../../model/iword';
import {DictionaryService} from '../../service/dictionary.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  wordDetails: IWord;
  constructor(private dictionaryService: DictionaryService,
              private activatedRoute: ActivatedRoute,
              private route: Router) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.wordDetails = this.dictionaryService.getDetails(parseInt(id));
  }
  backToWordsList() {
    this.route.navigateByUrl('dictionary');
  }
}
