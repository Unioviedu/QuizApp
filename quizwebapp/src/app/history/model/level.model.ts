export class Level {
    codSection:string;
    codLevel:string;
    name: string;
    main:boolean;
    unlocked:boolean;
    complete:boolean;
    numAttemps:boolean;
    numCorrectQuestion:number;
    numIncorrectQuestion:number;
    nextLevels:string[];
    questions:any[];
}