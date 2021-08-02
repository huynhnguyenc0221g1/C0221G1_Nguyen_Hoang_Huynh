import {Educations} from './education';
import {Positions} from './position';

export interface Employee {
  id?: number;
  name?: string;
  dateOfBirth?: string;
  education?: Educations;
  positions?: Positions;
}
