import { Component, OnInit } from '@angular/core';
import {IWord} from '../../model/iword';
import {DictionaryService} from '../../service/dictionary.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  wordList: IWord[] = [];
  constructor(private dictionaryService: DictionaryService ) { }

  ngOnInit(): void {
    this.wordList = this.dictionaryService.wordsList;
  }

}
