import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-section-card',
  templateUrl: './section-card.component.html',
  styleUrls: ['./section-card.component.css']
})
export class SectionCardComponent implements OnInit {
  @Input() section: any = {};
  classBadge = "badge badge-primary";

  constructor() { }

  ngOnInit() {
  }

  verSection(cod: string) {
    console.log(cod);
  }

}
