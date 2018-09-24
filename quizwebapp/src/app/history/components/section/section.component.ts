import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SectionsService } from '../../services/sections.service'

import { Section } from '../../model/section.model'
import { Level } from '../../model/level.model'
import { Challange } from '../../model/challange.model'

declare var jQuery: any;

@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css']
})
export class SectionComponent implements OnInit {
  @ViewChild('myModal') myModal;

  codSection: string;
  section: Section;
  titleSection: string;
  levelsMain: Level[];
  levelsOptional: Level[];
  challanges: Challange[];

  newLevels: any[];

  constructor(private activatedRoute: ActivatedRoute,
    private sectionsService: SectionsService) {
    this.activatedRoute.params.subscribe(params => {
      this.codSection = params["cod"];
    });
  }

  ngOnInit() {
    this.loadLevels();

    let newInfo = this.sectionsService.newInfo;

    if (newInfo) {
      this.newLevels = newInfo;
      jQuery(this.myModal.nativeElement).modal('show');
      this.sectionsService.changeInfo(null);
    }
  }

  loadLevels() {
    this.sectionsService.getSection(this.codSection)
      .subscribe(data => {
        this.section = data;
        this.titleSection = data.title;
        this.levelsMain = data.levels.filter(level => level.main).sort((a, b) => a.name.localeCompare(b.name));
        this.levelsOptional = data.levels.filter(level => !level.main).sort((a, b) => a.name.localeCompare(b.name));
        this.challanges = data.challanges;
      }
      );
  }

  getChallangeDescription(i: number) {
    return this.challanges[i].description + " " + this.challanges[i].complete;
  }

}
