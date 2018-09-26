import { Level } from './level.model';
import { Challange } from './challange.model';

export class Section {
    id: string;
    codSection: string;
    title: string;
    description: string;
    unlocked: boolean;
    completeAll:boolean;
    levels: Level[];
    nextSections: String[];
    challanges:Challange[];
}