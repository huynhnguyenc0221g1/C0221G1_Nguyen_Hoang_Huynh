import { Injectable } from '@angular/core';
import {IWord} from '../model/iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  wordsList: IWord[] = [
    {id: 1, word: 'Eat', means: 'Ăn'},
    {id: 2, word: 'Sleep', means: 'Ngủ'},
    {id: 3, word: 'Developing', means: 'Lập trình'},
    {id: 4, word: 'Study', means: 'Học'}
  ];
  constructor() { }
  getDetails(id: number) {
    for (let i = 0; i < this.wordsList.length; i++) {
      if (this.wordsList[i].id === id) {
        return this.wordsList[i];
      }
    }
    return null;
  }
}
